

import unittest 

import requests

class Testbasic(unittest.TestCase):
    
    def setUp(self):
        self.url = "http://localhost:9000"

    def test_basic(self):
        self.assertEqual(1+1, 2)
        self.assertEqual(requests.get(self.url).status_code, 200)
    
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
            "date": "2020-02-02"
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
            "volume": 0
        }, requests.get("%s/stock/" % self.url).json())

