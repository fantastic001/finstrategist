import yfinance as yf
import requests
import os

shares  = os.getenv("STOCKS").split(" ")
endpoint = os.getenv("WEB_HOOK")

for share in shares:
    print(share)
    s = yf.Ticker(share)
    # print(s.history("1mo"))
    print(s.info)
    data = {
        "close": s.info["previousClose"],
        "open": s.info["regularMarketOpen"],
        "high": s.info["dayHigh"],
        "low": s.info["dayLow"], 
        "volume": s.info["regularMarketVolume"],
        "dividend": s.info["dividendRate"],
    }
    print(data)
    requests.post(endpoint, data)