package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//AOPを実行するタイミングのクラス
//↓の２つはセットで使う
@Aspect //アスペクト指向のプログラミングにつける
@Component //DIコンテナにbeanとして登録したいクラスへ付与する
public class LogAspect {

	//	AOPの実装 メソッドの実行前にAOPの実装
	//Controllerと着くすべてのメソッドをAOPの対照としている
	@Before("execution(* *..*.*Controller.*(..))")
	private void starLog(JoinPoint jp) {

		System.out.println("メソッドの開始 : " + jp.getSignature());

	}

	//	AOPの実装 メソッドの実行後にAOPの実装
	//パラメータには、どのクラスのどのメソッドが実行されたときにこのメソッドが呼び出されるか指定
	//	executionの指定方法"execution(戻り値 パッケージ名.クラス名.メソッド名(引数))"
	//*は任意の文字列。..はゼロ以上という意味
	@After("execution(* *..*.*Controller.*(..))")

	private void endLog(JoinPoint jp) {

		System.out.println("メソッドの終了 : " + jp.getSignature());

	}
}
