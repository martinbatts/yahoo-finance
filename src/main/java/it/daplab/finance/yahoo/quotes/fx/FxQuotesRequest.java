
package it.daplab.finance.yahoo.quotes.fx;


import java.util.ArrayList;
import java.util.List;

import it.daplab.finance.yahoo.Utils;
import it.daplab.finance.yahoo.YahooFinance;
import it.daplab.finance.yahoo.quotes.QuotesProperty;
import it.daplab.finance.yahoo.quotes.QuotesRequest;

/**
 *
 * @author Stijn Strickx
 */
public class FxQuotesRequest extends QuotesRequest<FxQuote> {
    
    public static final List<QuotesProperty> DEFAULT_PROPERTIES = new ArrayList<QuotesProperty>();
    static {
        DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
        DEFAULT_PROPERTIES.add(QuotesProperty.LastTradePriceOnly);
    }
    
    public FxQuotesRequest(String query) {
        super(query, FxQuotesRequest.DEFAULT_PROPERTIES);
    }

    @Override
    protected FxQuote parseCSVLine(String line) {
        String[] split = Utils.stripOverhead(line).split(YahooFinance.QUOTES_CSV_DELIMITER);
        if(split.length >= 2) {
            return new FxQuote(split[0], Utils.getBigDecimal(split[1]));
        }
        return null;
    }
    
}
