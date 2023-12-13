# Test code 

"""
# sec: 0
# check env
import os

sEnv = os.getenv('PATH')
print(sEnv)
"""

"""
# sec: 1
# Get data from quandl and save it immediately. To avoid exceeding the allowance.

import pandas as pd
import quandl 

df = quandl.get("WIKI/GOOGL")
df.to_csv('../../data/quandl_dt.csv')

"""


"""
# sec: 2 
# test data from open data - Vancouver: housing
import pandas as pd

df = pd.read_csv("../../data/rental-standards-current-issues.csv", sep=';')
list(df.columns)

df = df[['BUSINESSOPERATOR', 'StreetNumber', 'Street', 'TOTALOUTSTANDING', 'TotalUnits', ]]
df['profit_PCT'] = df['TOTALOUTSTANDING'] / df['TotalUnits'] * 100

print(df.head())

"""

import pandas as pd

# set type for calaulation
types = {'Adj. Open': 'float64', 
        'Adj. High': 'float64', 
        'Adj. Close': 'float64'} 

df = pd.read_csv("../../data/quandl_dt.csv", dtype=types) 
print(list(df.columns))

# alternative: 
# panda.read_cvs default is str. data type could be set at the begining 
#       or later with to_numeric 
# df['Adj. High'] = pd.to_numeric( df['Adj. High'])
# df['Adj. Close'] = pd.to_numeric( df['Adj. Close'])
# df['Adj. Open'] = pd.to_numeric( df['Adj. Open'])

df = df[[ 'Adj. Open', 'Adj. High', 'Adj. Low', 'Adj. Close', 'Adj. Volume']]

df['HL_PCT'] = (df['Adj. High'] - df['Adj. Close']) / df['Adj. Close'] * 100
df['PCT_change'] = ( df['Adj. Close'] - df['Adj. Open'] ) / df['Adj. Open'] * 100 

df = df[['Adj. Close', 'HL_PCT', 'PCT_change', 'Adj. Volume']]
print(df.head())
