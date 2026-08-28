package org.crux.annotations

/**
 * Cruxプロジェクトのモジュール間でのみ使用を許可する内部向けAPIを示すアノテーションです。
 * 外部の一般利用者がオプトインなしでアクセスした場合、コンパイルエラーになります。
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
    message = "This API is internal to the Crux project modules and should not be used externally."
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
annotation class InternalCruxApi