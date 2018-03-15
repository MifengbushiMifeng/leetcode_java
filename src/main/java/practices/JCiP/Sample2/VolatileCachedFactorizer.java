package practices.JCiP.Sample2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class VolatileCachedFactorizer implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        BigInteger i = extractFromRequest(servletRequest);
        BigInteger i = new BigInteger("3");
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }

    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
