from yahoo_finance import Share 
import yfinance as yf



shares = [
    "AAPL",
]

for share in shares:
    s = yf.Ticker(share)
    print(s.info)