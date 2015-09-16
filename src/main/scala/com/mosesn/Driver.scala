package com.mosesn

import com.google.common.io.BaseEncoding

object Driver {
  def main(args: Array[String]): Unit = {
    println(args match {
      case Array("1", hex) => p1(hex)
      case Array("2", s1, s2) => p2(s1, s2)
      case _ => "You passed the wrong number of arguments for your functions, please pass in the format \"1\" $args"
    })
  }

  def p1(hex: String): String = {
    val hexEncoder = BaseEncoding.base16().lowerCase()
    val bytes = hexEncoder.decode(hex)
    val b64Encoder = BaseEncoding.base64()
    b64Encoder.encode(bytes)
  }

  def p2(s1: String, s2: String): String = {
    val encoder = BaseEncoding.base16().lowerCase()
    val ret = encoder.decode(s1).zip(encoder.decode(s2)).map {
      case (left, right) => (left ^ right).toByte
    }
    encoder.encode(ret)
  }
}
