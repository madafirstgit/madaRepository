/**    
 * 文件名：SerializeUtil.java    
 *    
 * 版本信息：    
 * 日期：2014-6-9    
 * Copyright 足下 Corporation 2014     
 * 版权所有    
 *    
 */
package com.pzj.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.dubbo.common.serialize.support.java.CompactedObjectInputStream;
import com.alibaba.dubbo.common.serialize.support.java.CompactedObjectOutputStream;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

/**
 * 
 * 
 * 项目名称：service.product.redis 类名称：SerializeUtil 类描述： 创建人：石月 创建时间：2014-6-14
 * 下午2:26:33 修改人：wushu 修改时间：2014-6-14 下午2:26:33 修改备注：
 * 
 * @version
 * 
 */
public class SerializeUtil {

	public static byte[] dubboSerialize(Object obj) {
		ByteArrayOutputStream os = null;
		CompactedObjectOutputStream out = null;
		byte[] b = null;
		try {
			os = new ByteArrayOutputStream();
			out = new CompactedObjectOutputStream(os);
			out.writeObject(obj);
			b = os.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	public static Object dubboUnserialize(byte[] bytes) {
		ByteArrayInputStream is = null;
		CompactedObjectInputStream in = null;
		Object obj = null;
		try {
			is = new ByteArrayInputStream(bytes);
			in = new CompactedObjectInputStream(is);
			obj = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	public static byte[] hessianSerialize(Object obj) {
		ByteArrayOutputStream os = null;
		Hessian2Output out = null;
		byte[] b = null;
		try {
			os = new ByteArrayOutputStream();
			out = new Hessian2Output(os);
			out.writeObject(obj);

			out.flushBuffer();
			b = os.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	public static Object hessianUnserialize(byte[] bytes) {
		ByteArrayInputStream is = null;
		Hessian2Input in = null;
		Object obj = null;
		try {
			is = new ByteArrayInputStream(bytes);
			in = new Hessian2Input(is);
			obj = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object value) {
		return hessianSerialize(value);
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		return hessianUnserialize(bytes);
	}

	/**
	 * JAVA序列化
	 * 
	 * @param object
	 * @return
	 */
	public static byte[] javaSerialize(Object value) {
		if (value == null) {
			throw new NullPointerException("Can't serialize null");
		}
		byte[] rv = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream os = null;
		try {
			bos = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bos);
			os.writeObject(value);
			os.close();
			bos.close();
			rv = bos.toByteArray();
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-serializable object", e);
		} finally {
			try {
				if (os != null)
					os.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				throw new IllegalArgumentException("Non-serializable object", e);
			}
		}
		return rv;
	}

	/**
	 * JAVA反序列化
	 * 
	 * @param bytes
	 * @return
	 */
	public static Object javaUnserialize(byte[] bytes) {
		Object rv = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream is = null;
		try {
			if (bytes != null) {
				bis = new ByteArrayInputStream(bytes);
				is = new ObjectInputStream(bis);
				rv = is.readObject();
				is.close();
				bis.close();
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Non-unserialize object", e);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Non-unserialize object", e);
		} finally {
			try {
				if (is != null)
					is.close();
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				throw new IllegalArgumentException("Non-unserialize object", e);
			}
		}
		return rv;
	}
}