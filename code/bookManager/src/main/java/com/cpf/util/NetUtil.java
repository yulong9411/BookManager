package com.cpf.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 * @author CPF
 *
 */
public class NetUtil
{
	/**
	 * 发送GET请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url)
	{
		BufferedReader reader = null;
		HttpsURLConnection conn = null;
		try
		{
			URL u = new URL(url);
			conn = (HttpsURLConnection) u.openConnection();
			conn.connect();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			StringBuilder sb = new StringBuilder();
			String str = "";
			while ((str = reader.readLine()) != null)
			{
				sb.append(str);
			}
			return sb.toString();
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{

			try
			{
				if (reader != null)
				{
					reader.close();
				}
				if (conn != null)
				{
					conn.disconnect();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 把参数连接到url上
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String concatParam(String url, Map<String, Object> params)
	{
		StringBuilder sb = new StringBuilder(url);
		if (params != null)
			for (Map.Entry<String, Object> entry : params.entrySet())
			{
				sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
			}
		return sb.toString();
	}
}
