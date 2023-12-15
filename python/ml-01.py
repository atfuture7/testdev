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
# sec: 1.5 
# Google big query https://cloud.google.com/python/docs/reference/bigquery/latest
# must be pay account 

from google.cloud import bigquery

client = bigquery.Client()

str = '''select 
  sum(daily_confirmed_cases) as cases, 
  sum(daily_deaths) as death,
  year,
  month,    
  countries_and_territories
from 
  bigquery-public-data.covid19_ecdc_eu.covid_19_geographic_distribution_worldwide as tb
where 
  date > "2020-01-01" and date < "2020-12-31"
  and countries_and_territories in ('United_States_of_America', 'United_Kingdom', 'Taiwan', 'Germany')
group by
  countries_and_territories , year, month
order by 
  countries_and_territories
'''

query_job = client.query(str)
rows = query_job.result()
cnt = 0

for row in rows:
    print(row.name)
    cnt += 1
    if cnt > 20: break

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
import math
import numpy as np 
from sklearn import preprocessing, cross_validation, svm
from sklearn.linear_model import LinearRegression 

# set type for calaulation
types = {'Adj. Open': 'float64',
        'Adj. High': 'float64', 
        'Adj. Close': 'float64'} 

df = pd.read_csv("../../data/quandl_dt.csv", dtype=types) 

# *** checking block
# print(df.head())
print(list(df.columns))

# alternative: 
# panda.read_cvs default is str. data type could be set at the begining 
#       or later with to_numeric 
# df['Adj. High'] = pd.to_numeric( df['Adj. High'])
# df['Adj. Close'] = pd.to_numeric( df['Adj. Close'])
# df['Adj. Open'] = pd.to_numeric( df['Adj. Open'])

df = df[['Date', 'Adj. Open', 'Adj. High', 'Adj. Low', 'Adj. Close', 'Adj. Volume']]

df['HL_PCT'] = (df['Adj. High'] - df['Adj. Close']) / df['Adj. Close'] * 100
df['PCT_change'] = ( df['Adj. Close'] - df['Adj. Open'] ) / df['Adj. Open'] * 100 

df = df[['Date', 'Adj. Close', 'HL_PCT', 'PCT_change', 'Adj. Volume']]

# *** checking block
# print(df.head())

forcast_col = 'Adj. Close'
df.fillna( -99999, inplace=True)

forcast_out = int(math.ceil(0.01*len(df)))

df.sort_values(by=['Date'])
df['label'] = df[forcast_col].shift(-forcast_out)

# *** checking block
# print(df.head())

df.dropna(inplace=True)

X = np.array(df.drop(['label'], 1))
y = np.array(df['label'])
X = preprocessing.scale(X)
y = np.array(df['label'])

X_train, X_test, y_train, y_test = cross_validation.train_test_split(X, y, test_size=0.2)

#clf = LinearRegression()



print(X_train)
