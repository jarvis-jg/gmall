package com.atguigu.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 商户appid
	public static String APPID = "2016092000556307";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCNNQ4Fxd+2iTuHu8pe6cYXRPI8Ll6ixRzZGXgWuyiDREMIdNo0L2yYUwnC6NKng7fULGqlEDoHgSPTXie4Gvw/cJmW50hB4EIdZCyxvvyBXYGQXUJ/Z+jwSbUmMuRbcKlFTL5YTEKL7mM24sgwQK0Y+4z1TcNTrCskZgkkVN5eiUZD9fTMOg6o/0L4wWu6P7HkyLBFcXPe74z6SO3PLbIZPBzxwoHxCsFcAlSwndWjigbsvHgdyVK2r0lckwzsPjBgET284dUsqebFrNp3DThM6xLJwuMxeOg8rT834VJst/wSlbhtcsPYTnfyPu7Wm9zGpj3tnydeiaY+VYtyKtAdAgMBAAECggEASZWkQQ3kjtLk2s7ZnqxkNiwPr5zaZCgj6F6FXhMaAY3JANcj/p3YEWj0ZUW+wNy7Jy4eRPY3x0Fc0gD24dHuMYEUCLdtyCZ9TaOuRtIn86IuqnRu+sXDdbRzWfybU6taCmr7pjfXVeRcf3WerMaHbcVop0xmxWuq78TcbrprRweoCT5w08Py7lfzqzx+TlpLiNsT77zUVHisGQi9X96KWnnvzMoiIWA18sB/WQSzzX1GTekLG3ggr5SETVtV5zyZ/iJmds9BkUdSr1K5P7LMuScXtAUM6mfI1ivVorqpkYw1jGRmuclSR28+Ixmglyw/DcniM50PEk9XEH8HjrXBYQKBgQDootd/qjX/3LYNFLRfdtN4WSbGMOq6Nh96hMMsqpGL1Cqw19LNQgekKhwaliY57YJh2fIG6y5663fwUqxUEq1XADx0PJvVpomrSxdfU4ewKt7EDtIS3Ce5MS/IVHKt2U3jiDAwzazxzO99l1WOi9J0quby6isTxhIjPkSZQJaxuwKBgQCbY4tIUiI7KBL8LbCBxxsx5+6ySiGXDHDXBM7Oc39ZO/sY77R3XvA6vI4ekSwDcBmbRl4S5TkQtHMbI3MzZ088XBSOyLsce+zAMkhrOrLVdgiVSc6QxakSRqSI1FF3cu3KZhoRUojdA0OXVOqq8f/AEKVyfZy21L7sH75AOlqcBwKBgQDdiUWC88qcr8hGSLNEPdpAP1XnYuoFDkmH2SosPPqBmDhXVBARG5I/SUKeJuKcQ4voNy5+XDRVJit/lps5LNgZg8YOQzF7ki6ECuxlARy0LP8a4ao3/6NsfmSsd48F82xzA1ww/Yx2b9yZUyZMquZt59oq9ciz+emH2mJlNtbKxQKBgCnEiBvYd/sOuouufFNmAZlYjoC+DGldnrctQ6mawhBqXwRE6m1rx4cCR/FPdFU4PKnQMFlD5CLpXkddMAoRKus+lQgMTL9LUEgZO/4WuRtHrubx/+RKPTf8ZR2idIN3ERPmfftKBB/kULbMzIdGpUgrMU2lFgrPBMLThYAeL1zhAoGBAIU/GUvXTdDH3sSvhrq27Oa+KvNYGqjZfUF1GLIBQYivAU6x7qMJnrL0TDz+znC7Atwl3YK4t0o5xfidWeZG6KPiaRRQ7t7NNv4sJ0RLk3CoKiFvnWs3zLN5VsJNNC7KSzmOBMpfsJa3+JaS9AJxpwvdoWVPjqH0lmCmX8FUmtvk";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8090/mall_sale_web_war_exploded/real_pay_success.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8090/mall_sale_web_war_exploded/pay_success.do";

	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/Library/workspace/idea_project/gmall/pay_service/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

}

