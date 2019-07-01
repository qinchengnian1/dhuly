package com.ecms.cums.utils.redis;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ObjectSerialization {
    private static final Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap();

    ObjectSerialization() {
    }

    public static <T> byte[] serialize(T obj) {
        Schema<T> schema = getSchema((Class<T>) obj.getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        Object var3 = null;

        byte[] protostuff;
        try {
            protostuff = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }

        return protostuff;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> targetClass) {
        Schema<T> schema = getSchema(targetClass);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        return obj;
    }

    public static <T> byte[] serializeList(List<T> objList) {
        Schema<T> schema = getSchema((Class<T>) objList.get(0).getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(512);

        byte[] protoStuff;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            Throwable var5 = null;

            try {
                ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
                protoStuff = bos.toByteArray();
            } catch (Throwable var23) {
                var5 = var23;
                throw var23;
            } finally {
                if (bos != null) {
                    if (var5 != null) {
                        try {
                            bos.close();
                        } catch (Throwable var22) {
                            var5.addSuppressed(var22);
                        }
                    } else {
                        bos.close();
                    }
                }

            }
        } catch (IOException var25) {
            throw new RuntimeException("Failed to serializer");
        } finally {
            buffer.clear();
        }

        return protoStuff;
    }

    public static <T> List<T> deserializeList(byte[] bytes, Class<T> targetClass) {
        Schema schema = getSchema(targetClass);

        try {
            List<T> result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), schema);
            return result;
        } catch (IOException var5) {
            throw new RuntimeException("Failed to deserialize");
        }
    }

    private static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema)cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.getSchema(cls);
            Schema<T> existing = (Schema)cachedSchema.putIfAbsent(cls, schema);
            if (existing != null) {
                schema = existing;
            }
        }

        return schema;
    }
}
