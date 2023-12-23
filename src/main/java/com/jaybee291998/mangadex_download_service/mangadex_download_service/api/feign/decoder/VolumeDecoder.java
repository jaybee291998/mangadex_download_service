//package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.client;
//
//import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
//import feign.FeignException;
//import feign.Response;
//import feign.codec.DecodeException;
//import feign.codec.Decoder;
////import feign.gson.GsonDecoder;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.Map;
//
//public class VolumeDecoder implements Decoder {
////    private final GsonDecoder delegate = new GsonDecoder();
//    @Override
//    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
//        Object decodedObject = delegate.decode(response, type);
//
//        if(decodedObject instanceof Map) {
//            return convertToVolumeResultModel((Map<?, ?>) decodedObject);
//        }
//        return decodedObject;
//    }
//
//    private VolumeResultModel convertToVolumeResultModel(Map<?, ?> map) {
//        return new VolumeResultModel();
//    }
//}
