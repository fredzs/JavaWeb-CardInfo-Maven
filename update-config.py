#!/usr/bin/env python
#-*- encoding:UTF-8 -*-

import os
import re
import sys
from jenkinsapi.jenkins import Jenkins
    
reload(sys)
sys.setdefaultencoding('utf-8')
f = open('./script.js','r')
javaScript = f.read()

baseUrl ='http://172.16.100.150:8085/'
homedir = os.getcwd()
server = Jenkins(baseUrl, username = 'zhangsheng', password = '12345')
jobKeys = server.keys();

def download(key, config):
  filePath = homedir + '\\configFiles\\'  + key
  if os.path.isdir(filePath):
    print(filePath + u'路径已存在')
  else:
    os.makedirs(filePath)
  output = open(filePath + "\\config.xml", "wb+")
  output.write(config)
  
def main():
  # for key in jobKeys:
  #     jobUrl = baseUrl + key
  #     job = server.get_job(key)
  #     config = job.get_config()
      # download(key, config);
      
      #newConfig = re.sub(r"<stableText>.*</stableText>","<stableText>" + javaScript + "</stableText>", config, 0, flags=re.DOTALL)
      #job.update_config(newConfig)
  
  j = server.get_job('bjmcManagerFE_beta')
  c = j.get_config()
  newC = re.sub(r"<stableText>.*</stableText>","<stableText>" + javaScript + "</stableText>", c,0,flags=re.DOTALL)
  j.update_config(newC)

main();

