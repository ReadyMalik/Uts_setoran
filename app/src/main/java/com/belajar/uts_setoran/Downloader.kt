package com.belajar.uts_setoran

interface Downloader {
    fun downloadFile(url: String): Long
}