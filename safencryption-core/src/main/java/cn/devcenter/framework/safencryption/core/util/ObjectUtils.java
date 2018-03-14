package cn.devcenter.framework.safencryption.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ObjectUtils {

    /**
     * 序列化对象数组
     *
     * @return set
     */
    public static Set<Object> unserializeSet(Collection<byte[]> byteCollection) {
        Set<Object> objectSet = new HashSet<>();
        for (byte[] bytes : byteCollection) {
            objectSet.add(ObjectUtils.unserialize(bytes));
        }
        return objectSet;
    }

    /**
     * 序列化对象数组
     *
     * @return byte[][]
     */
    public static byte[][] serializeArray(Object... objects) {
        byte[][] byteObjects = new byte[objects.length][];
        for (int i = 0; i < objects.length; i++) {
            byteObjects[i] = serialize(objects[i]);
        }
        return byteObjects;
    }

    /**
     * 序列化对象
     *
     * @param object o
     * @return byte[]
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            if (object != null) {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                return baos.toByteArray();
            }
        } catch (IOException e) {
            if (log.isDebugEnabled()) {
                log.debug("序列化对象IO错误", e);
            }
        }
        return null;
    }

    /**
     * 反序列化对象
     *
     * @param bytes byte[]
     * @return object
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            if (bytes != null && bytes.length > 0) {
                bais = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            }
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("反序列化对象IO错误", e);
            }
        }
        return null;
    }

}
