# AsiaYo 面試試題：API實作

## 相關依賴
* JDK 1.8
* Maven 3.6.3

## 如何開始
請跟隨以下腳步啟動server並且發送請求到該API

### 啟動server
開啟終端機，移動至專案資料夾中：/path/to/AsiaYo-Exercise  
已經將專案打包成jar檔案，可以直接用command執行
```
cd /path/to/AsiaYo-Exercise
java -jar AsiaYo_Exercise-0.0.1.jar
```
### API
使用browser或習慣的軟體對以下的API進行get請求
```
http://localhost:8080/api/exchange?source={source}&target={target}&amount={amount}
```

## 如何測試
以下測試會使用maven來進行測試

### 開始測試
開啟終端機，移動至專案資料夾中：/path/to/AsiaYo-exercise  
執行以下command進行測試
```
cd /path/to/AsiaYo-Exercise
mvn test
```





