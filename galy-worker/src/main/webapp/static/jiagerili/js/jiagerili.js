﻿window.onload=function(){
		var s1=new selectDate();
		s1.init('date',{
			startDate: '2017-6-10',
			endDate: '2017-11-11',
			data: [{
				date: '2017-6-11',
				price: '100'
			},
			{
				date: '2017-7-13',
				price: '100',
				rest: '休'
			},
			{
				date: '2017-8-15',
				price: '100',
				discount: '折'
			}]
		});
	}
var json = {
	startDate: '2017-8-10',
	endDate: '2018-1-15',
	dateJson: [{
		date: '2017-10-11',
		price: '100'
	},
	{
		date: '2017-8-13',
		price: '100',
		rest: '休'
	},
	{
		date: '2017-8-15',
		price: '100',
		discount: '折'
	}]
}
function selectDate(){
	this.wrapperDIV=null;
	this.settings={
		startDate: '2017-8-10',
		endDate: '2018-1-15',
		data:json.dateJson
	}
}
selectDate.prototype.init=function(obj,opt){
	extend(this.settings, opt);
	this.wrapperDIV=document.getElementById(obj);
	this.getDate();
}
selectDate.prototype.getDate=function() {
	let allDate = getAll(this.settings.startDate, this.settings.endDate);
	allDate.splice(allDate.length-1, 1);
	let str = '';
	let className = '';

	allDate.forEach((item, index) => {
		let yearMonth = item.year + '-' + item.month;
		let yearMonthDay = item.year + '-' + item.month + '-' + item.day;

		switch (compareDate(this.settings.startDate, this.settings.endDate, yearMonthDay)) {
			case 'day':
				className = 'day';
				break;
			case 'future':
				className = 'future';
				break;
			case 'pass':
				className = 'pass';
				break;
		};

		let tag = this.pushTag(yearMonthDay);
		let dateLi1 = '<div class="date-title">'+item.year+'年'+item.month+'月</div><ul date='+yearMonth+'>'+ getNbsp(item.week) +'<li class='+className+' date='+yearMonthDay+'>' + item.day + tag+'</li>';
		let dateLi2 = '<li class='+className+' date='+yearMonthDay+'>'+ item.day + tag+ '</li>';
		let dateLi3 = '</ul><div class="date-title">'+item.year+'年'+item.month+'月</div><ul date='+yearMonth+'>'+ getNbsp(item.week) +'<li class='+className+' date='+yearMonthDay+'>' + item.day + tag+ '</li>';

		if (index > 0) {
			item.month === allDate[index-1].month? str += dateLi2: str += dateLi3;
		} else {
			str += dateLi1;
		}
	});

	str += '</ul>';
	//console.log(str)
	this.wrapperDIV.innerHTML=str;
	return str;
}
selectDate.prototype.pushTag=function(yearMonthDay) {
	let tag='';
	for (let i = 0; i < this.settings.data.length; i++) {
		if (yearMonthDay === this.settings.data[i].date) {
			for (let key in this.settings.data[i]) {
				key === 'price' ? tag += '<i class='+key+'>￥'+this.settings.data[i][key]+'</i>' :tag += '<i class='+key+'>'+this.settings.data[i][key]+'</i>';
			}
			break;
		}
	}
	return tag;
}


function compareDate(date1, date2, now) {
	let d1 = new Date(date1);
	let d2 = new Date(date2);
	let n = new Date(now);
	if (date1 !== '' && now !== '' && d1 > n) {
		return 'pass';
	}
	if (date2 !== ''&& now !== '' && n > d2) {
		return 'future';
	}
	return 'day';
}
function getNbsp(week) { // 根据每个月1号是周几来补全前面的空格
	let str = '';
	for (let i = 0; i < week; i++) {
			str += '<li>&nbsp</li>';
	}
	return str;
}
function getFirstAndLastMonthDay(year, month) { // 获取当前月的最后一天
	 let day = new Date(year, month, 0);
	 let lastdate = year + '-' + month + '-' + day.getDate(); // 获取当月最后一天日期
	 return lastdate;
}
function DateFormat(obj) {
			let mouth = (obj.getMonth() + 1)>=10?(obj.getMonth() + 1):((obj.getMonth() + 1));
			let day = obj.getDate()>=10?obj.getDate():(obj.getDate());
			let week = new Date(obj.getFullYear() + '/' + mouth + '/' + day).getDay()
			return ({year: obj.getFullYear(), month: mouth, day: day, week: week}); // 返回日期。
}
function getAll(begin, end) { // 获取两个日期间的所有日期
	let myBegin = begin.split('-')[0] + '-' + begin.split('-')[1] + '-' + 1;
	let myEnd = getFirstAndLastMonthDay(end.split('-')[0], end.split('-')[1]);
	let dateArr = [];
	let ab = myBegin.split('-');
	let ae = myEnd.split('-');
	let db = new Date();
	db.setUTCFullYear(ab[0], ab[1] - 1, ab[2]);
	let de = new Date();
	de.setUTCFullYear(ae[0], ae[1] - 1, ae[2]);
	let unixDb = db.getTime();
	let unixDe = de.getTime();
	for (let k = unixDb; k <= unixDe;) {
			dateArr.push(DateFormat(new Date(parseInt(k))));
			k = k + 24 * 60 * 60 * 1000;
	}
	return dateArr;
}


function extend(set, opt) {
	for ( var property in opt) {
	    set[property] = opt[property];
	}
	return set;
}