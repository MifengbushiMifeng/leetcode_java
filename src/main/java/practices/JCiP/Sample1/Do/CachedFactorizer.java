package practices.JCiP.Sample1.Do;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class CachedFactorizer implements Servlet {

    private BigInteger lastNumber;

    private BigInteger[] lastFactors;

    private long hits;

    private long cachedHits;

    public synchronized long getHits() {
        return hits;
    }


    public synchronized double getCachedHitRadio() {
        return (double) cachedHits / (double) hits;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        BigInteger i = extractRequest();
        BigInteger[] factors = null;

        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cachedHits;
                factors = lastFactors.clone();
            }
        }
        if (factors == null) {
            factors = factors(i);
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
    }

    private BigInteger[] factors(BigInteger i) {
        return new BigInteger[0];
    }

    private BigInteger extractRequest() {
        return new BigInteger(String.valueOf(3));
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
