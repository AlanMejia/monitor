package dummy;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 8/26/2016.
 */
@Component
public class FlagObject {

    protected String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
