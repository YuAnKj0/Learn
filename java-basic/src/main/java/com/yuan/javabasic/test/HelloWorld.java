package com.yuan.javabasic.test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Base64;

public class HelloWorld {
    public static void main(String []args) throws Exception {
       
        String cipherText = "mq4s/zhZQcd3VPf8qNKVJGKZLufjQComphGjbb0+RwJIUi02X5pCNCG6j5llUSCp6iofbBAYcM+AVj/GxB1YxszEqQcp0kZr5XinwcxgQftc158saDDOHI/dRdWP0f+ZZW6c9w197xev4doCVWAIko6BbHwUR1mDVoDBAgwSXEHKYopuoFDHHw6h1LvVE9t6b6Iqmz1sfXdCm5EQrnlx8Jw+5TdoByrVs86ATCNfBWeuAuXFeeKLRhuJhSOPN1Of3TQ9rGYGWNKC+6/wknSTYvVn8FgjvD7gSQtYPDqSct44DVuHmbyAtdLaGaKTeODaNPBSceXq5fYMotgXAw5+XvoSqJi4eV84ePKEYV96ix0= " +
                "mq4s/zhZQcd3VPf8qNKVJKhrJLRz45tGqzEukt9TW6Cw7IjzyInvrtXOnUt+n1d/mfsZ05qE1xCAzqxAuF96dgV5vTWD31lJwOtEOEXX8bcsOmyHNx9r6cy2nWo8Ngx1FFhUQdpIwmf2WLSvYoGeH+kl/Czxw+DB+kFWEey0qxEgtjTVv878fWPbp98AmiWf3dkY1IPjhlqGJLSOCTO1YSNx5ZB4qP697RbAwiK9Js6DTVE75rD+1ro1JyYEO4vnHrCYSEsxI2/nVPO0TuB5VLXwsnvfYGInY3Y4TBf0znnK9PUkez3CErtW8iOKsT4hrO27B6c/JdRMgVGvukubC74nAHK7YLvtrw8DrAMHATs= " +
                "mq4s/zhZQcd3VPf8qNKVJL5qVUaF7H3xJ2nhMGu1Uqzj9rVkvD1j/9k6+05jt/I/bFQ+PpqisVUiEfFZu5kuv9EalKYhkPVVq5tM+qz4wkVWDexnQQk6SJJi2AmjD+xlyp4w35gfJtJFt9vT4nWFuZ+h26GLqkN9FV/wPc+EIJsvqTBlJck6O/Np+LUEvjbKSV3PVYSz1i+DIJYhQBmxg/jGML0JeHFARN//JAgnt6av72dXP2v2Zycp/wTnnYjp5+iEkGWxq3FIAXuRRmjPiSAlRnv2GOxyGNLf5ZqkRkPNrMDRTNSid784Mum+Fa70DbCBu5cN+sKMv9Y8UrL5/0+6hxGGoIvhUdNtm+hb0TE= " +
                "mq4s/zhZQcd3VPf8qNKVJGGWyl4YeKExonJOkdym3MMFrrnnwy06gAv4SATq+dh6WxpLu/K9LzucL21x+hKIRfVXgqF4ayUTebn0tJ3Wy98w4R8hd37Kqq8hEgAtWOY55ro/xzlcKC27AwLdOwIjmCQlXMmeQ0mvrBUB+Mx5zdynQCYVDRq849tu3+mq3Lq9Y1pUbegOqvz+mH3gzDhT9Znv/QrIG+jDMFGLmHNCS/qOpHj/UDJB8o+X4kT6anxeg8N7RL/9ZSrewGgClzZwdhDbBPk5I03AJgM5ec5hNZgJ35TPt6v5kv5noTXZQeNAdCxbzNGM0baBWFLynmIsr8Xne/vyFWcfedGDvwJUlsA= " +
                "mq4s/zhZQcd3VPf8qNKVJK02ad+o6L9iq6jKCdI1t1E9Nf9FLMOsRGx/OwhJqHL68GXEV3gbfypKDEs4GTwaIHLTQIOyLLavWF2j1N89RtHefByLRQ/MDIPCy29I0ytp2Z8R4ewozM1pImnqXZ2GEWfyGzftqT0J91euJkHAnLMZNAHynhzA6rRehUtq5BEZWNYfgPoQ/P23dGiEchzlIUjnIAKcQwT8enYo90iQ8CWwVdrsHv5aL2HwTgeQRlbtpCCBCUHLPuTkLTzxBvGLTdsW5T8lmyP8d4/nNHyT1V6ZXzNVJDkN2XUOHQ57dj0wwh4dOcuokgK+sPUQiLs3sLvWghpyxDMhE3uKonZouQ0= ";
        
        String key = "ks9KUrbWJj46AftX"; //heidong\leiting\mifeng KEY
        //key = "awdtif20190619ti"; //xuanfen KEY
        
        String[] strArray=cipherText.split(" ");
        for (String text : strArray) {
          System.out.println(decrypt(text,key));
        }
    }
	public static String decrypt(String str, String str2) throws Exception {
		Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
		byte[] bytes = str2.getBytes(Charset.forName("UTF-8"));
		SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
		byte[] bytes2 = str2.getBytes(Charset.forName("UTF-8"));
		instance.init(2, secretKeySpec, new IvParameterSpec(bytes2));
		byte[] doFinal = instance.doFinal(Base64.getDecoder().decode(str));
		return new String(doFinal, Charset.forName("UTF-8"));
    }
}
