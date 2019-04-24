package yhao.micro.service.qiaolong_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.micro.service.qiaolong_demo.apilist.restful.TraceTestFeign;

@Service
public class TraceTestService {
    @Autowired
    private TraceTestFeign traceTestFeign;

    public Boolean traceOut() {
        traceTestFeign.traceInner();
        System.out.println("traceOut");
        return true;
    }

    public Boolean traceInner() {
        System.out.println("traceInner");
        return true;
    }
}
