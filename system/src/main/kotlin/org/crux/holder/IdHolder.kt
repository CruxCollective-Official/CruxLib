package org.crux.holder

/**
 * IDを保有する場合の管理する共通契約です。
 *
 * @param TYPE IDの型
 */
interface IdHolder<TYPE> {
    /**
     * idを返します。
     *
     * @return [TYPE]型のIDを返します。
     */
    fun id(): TYPE
}