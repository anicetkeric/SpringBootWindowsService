# SpringBootWindowsService
spring boot windows service

Windows Service for Spring Boot Application by Procrun

create Install.bat
```
prunsrv.exe //IS//windows_service-demo --DisplayName="windows_service-demo" --Description="Spring Windows Service Demo" --Startup=auto --
Install=%CD%\prunsrv.exe --Jvm=auto --Classpath=%CD%\windows_service-0.0.1.jar --StartMode=jvm --StartClass=com.service.procrun.Bootstrap --StartMethod=start --StartParams=start --StopMode=jvm --StopClass=com.service.procrun.Bootstrap --StopMethod=stop --StopParams=stop --StdOutput=auto --StdError=auto --LogPath=%CD% --LogLevel=Debug
```



![output](https://github.com/anicetkeric/SpringBootWindowsService/blob/master/procrun/image.png)
