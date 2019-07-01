<style  type="text/css">

.tip_pages a, .page_box .tip_pages .check_page{
    display:inline-block;
    width:20px;
    height:20px;
    text-align:center;
    line-height:20px;
    border:#e8e8e8 solid 1px;
    margin-left:7px;
    }


</style>

[#assign curPage = pageUtil.curPage]
[#assign pageSize = pageUtil.pageSize]
[#assign totalPage = pageUtil.totalPage]
[#assign totalRow = pageUtil.totalRow]

[#if url?contains("?")]
    [#assign param_char='&']
[#else]
    [#assign param_char='?']
[/#if]
[#if !url?ends_with("?") && !url?ends_with("&")]
    [#assign purl]${url + param_char}[/#assign]
[#else]
    [#assign purl = url]
[/#if]

[#assign purl]${purl}pageSize=${pageUtil.pageSize}&[/#assign]

[#if totalPage > 3]
    [#assign start = curPage - 1]
    [#if start < 1]
        [#assign start = 1]
    [/#if]
    [#assign end = start + 2]
    [#if end > totalPage]
        [#assign end = totalPage]
        [#assign start = end - 2]
    [/#if]
[#else]
    [#assign start = 1]
    [#assign end = totalPage]
[/#if]
[#assign _prePage = start - 1]
[#assign _nextPage = end + 1]
[#assign prePage = curPage - 1]
[#assign nextPage = curPage + 1]

[#if totalRow > 0]
	<div class="pagination">
	[#if curPage == 1]
		<span class="firstPage">&nbsp;</span>
	[#else]
		<a class="firstPage" href="${purl}curPage=1">&nbsp;</a>
	[/#if]
	[#if curPage > 1]
		<a class="previousPage" href="${purl}curPage=${prePage}">&nbsp;</a>
	[#else]
		<span class="previousPage">&nbsp;</span>
	[/#if]

	[#list pageUtil.segment as idx]
		[#if idx_index == 0 && idx > 2]
			<span class="pageBreak">...</span>
		[/#if]
		[#if idx != curPage]
			<a href="${purl}curPage=${idx}">${idx}</a>
		[#else]
			<span class="currentPage">${idx}</span>
		[/#if]
		[#if !idx_has_next && idx < totalPage - 1]
			<span class="pageBreak">...</span>
		[/#if]
	[/#list]

	[#if curPage < totalPage]
		<a class="nextPage" href="${purl}curPage=${nextPage}">&nbsp;</a>
	[#else]
		<span class="nextPage">&nbsp;</span>
	[/#if]
	[#if curPage == totalPage]
		<span class="lastPage">&nbsp;</span>
	[#else]
		<a class="lastPage" href="${purl}curPage=${totalPage}">&nbsp;</a>
	[/#if]

	<span class="pageSkip">
		共${totalPage}页
		到第<input id="_pageNum" name="pageNumber" value="${curPage}" maxlength="9" onpaste="return false;" />页
		<button type="submit" onclick="turnToTheSpecificPage('${purl}curPage=');return false;">&nbsp;</button>
		<input id="pageSize" value"${pageSize}" type="hidden" />
	</span>
	</div>
[#else]
<div class="pagin fr"> <span class="text">没有相关记录</span></div>
[/#if]

