package org.crux.system.convert

import org.crux.core.createCruxKey
import org.crux.system.key.Key

/**
 * 異なるデータ型とシリアライズされた文字列との間の相互変換を定義するインターフェース。
 *
 * @param V 変換対象となる元のデータ型
 */
interface ConvertType<V> {
    /**
     * データ型を識別するための固有の文字列タグを取得します。
     *
     * @return 型識別子となる文字列（例: "int", "Key"）
     */
    fun getKeyTag(): Key

    /**
     * 指定されたデータ型のオブジェクトを、型タグ付きの文字列に変換します。
     *
     * @param source 変換元のデータオブジェクト
     * @return 型タグが付与されたシリアライズ文字列
     */
    fun stringConvertLogic(source: V): String

    /**
     * 型タグ付きの文字列を、元のデータ型のオブジェクトに復元します。
     *
     * @param source 型タグが含まれるシリアライズ文字列
     * @return 復元されたデータ型のオブジェクト
     * @throws Exception 文字列のパースに失敗した場合
     */
    fun dataTypeConvertLogic(source: String): V
}

/**
 * [Int] 型のデータを扱うための [ConvertType] 実装クラス。
 * 形式: "integer>値" (例: "integer>123")
 */
class IntegerConvertType : ConvertType<Int> {
    override fun getKeyTag(): Key {
        return createCruxKey("integer")
    }

    override fun stringConvertLogic(source: Int): String {
        return "${getKeyTag().identifier}>$source"
    }

    override fun dataTypeConvertLogic(source: String): Int {
        return removeTag(getKeyTag().identifier, source).toInt()
    }
}

/**
 * [Double] 型のデータを扱うための [ConvertType] 実装クラス。
 * 形式: "double>値" (例: "double>3.14")
 */
class DoubleConvertType : ConvertType<Double> {
    override fun getKeyTag(): Key {
        return createCruxKey("double")
    }

    override fun stringConvertLogic(source: Double): String {
        return "${getKeyTag().identifier}>$source"
    }

    override fun dataTypeConvertLogic(source: String): Double {
        return removeTag(getKeyTag().identifier, source).toDouble()
    }
}

/**
 * [String] 型のデータを扱うための [ConvertType] 実装クラス。
 * 形式: "string>値" (例: "string>hello")
 */
class StringConvertType : ConvertType<String> {
    override fun getKeyTag(): Key {
        return createCruxKey("string")
    }

    override fun stringConvertLogic(source: String): String {
        return "${getKeyTag().identifier}>$source"
    }

    override fun dataTypeConvertLogic(source: String): String {
        return removeTag(getKeyTag().identifier, source)
    }
}

/**
 * [Boolean] 型のデータを扱うための [ConvertType] 実装クラス。
 * 内部的には真（true）を "1"、偽（false）を "0" として文字列化します。
 * 形式: "boolean>1" または "boolean>0"
 */
class BooleanConvertType : ConvertType<Boolean> {
    override fun getKeyTag(): Key {
        return createCruxKey("boolean")
    }

    override fun stringConvertLogic(source: Boolean): String {
        val byteValue = if (source) "1" else "0"
        return "${getKeyTag().identifier}>$byteValue"
    }

    override fun dataTypeConvertLogic(source: String): Boolean {
        return removeTag(getKeyTag().identifier, source) == "1"
    }
}


/**
 * 対象の文字列から、指定された型タグと区切り文字（>）を削除します。
 *
 * @param tag 削除対象の型タグ（例: "int"）
 * @param source タグが含まれている全体の文字列（例: "int>10"）
 * @return タグと区切り文字が取り除かれたデータ部分の文字列（例: "10"）
 */
fun removeTag(tag: String, source: String): String {
    return source.removePrefix("$tag>")
}