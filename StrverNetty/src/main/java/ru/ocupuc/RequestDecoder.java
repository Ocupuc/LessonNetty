package ru.ocupuc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.util.List;

public class RequestDecoder extends ReplayingDecoder<RequestData> {

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {

        RequestData data = new RequestData(); // Создаем новый объект класса RequestData
        data.setIntValue(in.readInt());// Декодируем целочисленное значение из байтового буфера

        // Декодируем длину строки из байтового буфера
        int strLen = in.readInt();

        // Декодируем строку из байтового буфера с помощью заданной кодировки
        data.setStringValue(
                in.readCharSequence(strLen, charset).toString());

        // Добавляем декодированные данные в список выходных данных
        out.add(data);
    }
}

