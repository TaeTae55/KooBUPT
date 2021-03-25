package com.Services.imp;

import com.Services.InfoBiz;
import com.entity.Info;
import com.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service("infoBiz")
public class InfoBizImp implements InfoBiz {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public Info get() throws IOException {
        return infoMapper.get();
    }

    @Override
    public int setSession(int session) throws IOException {
        Info info = new Info();
        info.setSession(session);
        info.setIid(1);
        return infoMapper.setSession(info);
    }

    @Override
    public int setPeriod(int period) throws IOException {
        Info info = new Info();
        info.setPeriod(period);
        info.setIid(1);
        return infoMapper.setPeriod(info);
    }

    @Override
    public int setRange(int range) throws IOException {
        Info info = new Info();
        info.setRange(range);
        info.setIid(1);
        return infoMapper.setRange(info);
    }
}
