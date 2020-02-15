package com.example.cleanskeleton.di.module

//TODO
//@Module
//class NetworkModule {
//
//    @Provides
//    @ApplicationScope
//    fun provideOkHttpClient(): OkHttpClient =
//        OkHttpClient.Builder().apply {
//            if (BuildConfig.DEBUG) {
//                addInterceptor(HttpLoggingInterceptor().apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                })
//            }
//        }.build()
//
//    @Provides
//    fun provideGson(): Gson {
//        return GsonBuilder().create()
//    }
//
//    @Provides
//    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https:/ostafin.me/")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
//            .build()
//    }
//
//    @Provides
//    fun provideAppInfoService(retrofit: Retrofit): AppInfoService {
//        return retrofit.create<AppInfoService>(AppInfoService::class.java)
//    }
//
//}