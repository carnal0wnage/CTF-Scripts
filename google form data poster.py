#Google Forms Data Poster
#Authour: Ajin Abraham
# Learn | Contribute | Share
#http://www.opensecurity.in
#=====================================
#!/usr/bin/python

import urllib,urllib2
#POST URL OF YOUR GOOGLE FORM
url="https://docs.google.com/forms/d/xxxxxxxx" #edit and give the google form url here
data={
       'xxxx':'TEST DUMP DATA' # your text field name and value you want to submit
     }
try:
  dataenc=urllib.urlencode(data)
	req=urllib2.Request(url,dataenc)
	response=urllib2.urlopen(req)
	print response.geturl()
	print response.info()
	page=response.read()
	print page
except Exception as e:
	print e

