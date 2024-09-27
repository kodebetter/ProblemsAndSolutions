package com.sandeep.atlassin.ratelimit.service;

import com.sandeep.atlassin.ratelimit.constants.TokenConstants;
import com.sandeep.atlassin.ratelimit.dto.TokenBucket;

import java.util.Date;

public class InitializeTokenBucket {
    public InitializeTokenBucket() {
        Date currentTime=new Date(System.currentTimeMillis());
        Date nextTime=new Date(currentTime.getTime()+ TokenConstants.TIME_WINDOW);
        TokenBucket tokenBucket=new TokenBucket(TokenConstants.BUCKET_SIZE,TokenConstants.TOKEN_COUNT,TokenConstants.TIME_WINDOW,nextTime);
    }
}
