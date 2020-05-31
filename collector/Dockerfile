from python:3.7

run pip install yahoo-finance yfinance lxml && \
    apt-get install -y libxml2 

COPY ./* /opt/

ENTRYPOINT python /opt/collector.py 