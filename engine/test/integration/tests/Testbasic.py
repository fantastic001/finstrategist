

import unittest 

import datetime
import requests

class Testbasic(unittest.TestCase):
    
    def setUp(self):
        self.url = "http://localhost:9000"
    
    def today(self, dt=0):
        return datetime.datetime.strftime(datetime.datetime.today() + datetime.timedelta(days=dt) , "%Y-%m-%d")

    def test_basic(self):
        self.assertEqual(1+1, 2)
        self.assertEqual(requests.get("%s/stock/" % self.url).status_code, 200)
    
    def test_list_stocks(self):
        self.assertEqual(requests.get("%s/stock/" % self.url).status_code, 200)
    
    def test_adding_stock(self):
        requests.post("%s/stock/" % self.url, json={
            "close": 20,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "date": "2020-02-02",
            "volume": 253453
        })
        self.assertIn({
            "id": 1,
            "close": 20,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "date": "2020-02-02",
            "volume": 253453
        }, requests.get("%s/stock/" % self.url).json())

    def test_decreasing_portfolio_cash(self):
        requests.post("%s/stock/" % self.url, json={
            "close": 20,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today()
        })
        requests.post("%s/stock/" % self.url, json={
            "close": 12,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today(-1)
        })
        requests.post("%s/stock/" % self.url, json={
            "close": 10,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today(-2)
        })
        requests.post("%s/stock/" % self.url, json={
            "close": 2,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today(-3)
        })
        requests.post("%s/stock/" % self.url, json={
            "close": 1,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today(-4)
        })
        requests.post("%s/stock/" % self.url, json={
            "close": 0,
            "open": 12,
            "high": 50,
            "low": 2,
            "dividend": 2,
            "ticker": "AAPL",
            "volume": 23432,
            "date": self.today(-5)
        })
        requests.post("%s/portfolio" % self.url, json={
            "cash": 2000000,
            "assets": []
        })
        self.assertGreater(2000000, requests.get("%s/portfolio/" % self.url).json()[0]["cash"])

