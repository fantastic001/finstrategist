from python:3.7

run pip install requests yfinance lxml && \
    apt-get install -y libxml2 

COPY ./* /opt/

ENV STOCKS="AAPL"
ENV WEB_HOOK="localhost:80/Stock"

ENTRYPOINT python /opt/collector.py 