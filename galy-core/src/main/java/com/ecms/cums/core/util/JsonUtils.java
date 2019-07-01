package com.ecms.cums.core.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Created by Administrator on 2017/6/2.
 */
public class JsonUtils
{
    private static final Logger logger = LogManager.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static String serialize(Object object)
    {
        Writer write = new StringWriter();
        try
        {
            objectMapper.writeValue(write, object);
        }
        catch (JsonGenerationException e)
        {
            logger.error("JsonGenerationException when serialize object to json", e);
        }
        catch (JsonMappingException e)
        {
            logger.error("JsonMappingException when serialize object to json", e);
        }
        catch (IOException e)
        {
            logger.error("IOException when serialize object to json", e);
        }
        return write.toString();
    }


    public static <T> T deserialize(String json, Class<T> clazz)
    {
        Object object = null;
        try
        {
            object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));
        }
        catch (JsonParseException e)
        {
            logger.error("JsonParseException when serialize object to json", e);
        }
        catch (JsonMappingException e)
        {
            logger.error("JsonMappingException when serialize object to json", e);
        }
        catch (IOException e)
        {
            logger.error("IOException when serialize object to json", e);
        }
        return (T) object;
    }


    public static <T> T deserialize(String json, TypeReference<T> typeRef)
    {
        try
        {
            return (T) objectMapper.readValue(json, typeRef);
        }
        catch (JsonParseException e)
        {
            logger.error("JsonParseException when deserialize json", e);
        }
        catch (JsonMappingException e)
        {
            logger.error("JsonMappingException when deserialize json", e);
        }
        catch (IOException e)
        {
            logger.error("IOException when deserialize json", e);
        }
        return null;
    }
    
    /**    
     * 获取泛型的Collection Type   
     * @param collectionClass 泛型的Collection    
     * @param elementClasses 元素类    
     * @return JavaType Java类型    
     * @since 1.0    
     */     
	 public static JavaType getCollectionType(ObjectMapper mapper,Class<?> collectionClass, Class<?>... elementClasses) {     
	     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);     
	 }  
	 
	 public static <T> T getList(String json, Class<T> class1,Class class2){
	        Object object = null;
	        ObjectMapper mapper = new ObjectMapper();
	        try
	        {
	            object = mapper.readValue(json, getCollectionType(mapper,TypeFactory.rawClass(class1), TypeFactory.rawClass(class2)));  
	        }
	        catch (JsonParseException e)
	        {
	            logger.error("JsonParseException when serialize object to json", e);
	        }
	        catch (JsonMappingException e)
	        {
	            logger.error("JsonMappingException when serialize object to json", e);
	        }
	        catch (IOException e)
	        {
	            logger.error("IOException when serialize object to json", e);
	        }
	        return (T) object;
	    }
}
