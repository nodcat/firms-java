# firms-java

## TIPS

如果你是中文用户，请从 [README-ZH.md](README-ZH.md) 获取帮助。

## What is firms-java?
A Java client for satellite data from NASA's Fire Information for Resource Management System (FIRMS), designed to easily construct requests for satellite data from NASA FIRMS. It can be integrated into Java projects and SpringBoot projects.

## What is FIRMS?
The Fire Information for Resource Management System (FIRMS) distributes near real-time (NRT) active fire data from the Moderate Resolution Imaging Spectroradiometer (MODIS) aboard the Aqua and Terra satellites, as well as the Visible Infrared Imaging Radiometer Suite (VIIRS) aboard S-NPP, NOAA 20, and NOAA 21 (officially named JPSS-1 and JPSS-2).

Official Website: [https://firms.modaps.eosdis.nasa.gov](https://firms.modaps.eosdis.nasa.gov/)

## Structure

1. satellite-core: The core package, containing the basic SatelliteClient and core methods.
2. satellite-spring: Adds auto-configuration with Spring dependencies, providing support for Spring and SpringBoot.
3. satellite-application: A demonstration of SpringBoot integration services.

## Obtaining the API Key

To access FIRMS satellite data, you need to obtain a MapKey from the official website. You can get it through the following two methods:

### Method 1
You can obtain the key by entering your email address in the dialog box on the official [API Key Acquisition](https://firms.modaps.eosdis.nasa.gov/api/map_key/) page.
![img.png](doc/2c37f5ed-e161-47dd-bf97-545251b01cde.png)

### Method 2
If you are running a web project integrated with the Spring package via SpringBoot:
1. After importing the dependencies and starting the project, access `http://127.0.0.1:[actual running port]/satellite.html`
2. Enter your email address and click "Send Email" to obtain the MapKey.
   ![img.png](doc/67480640-2172-4854-aa93-7bb728c47faa.png)

## Spring Configuration File

```yaml
nasa:
  # Obtained API key
  map-key: 35ece758e7525ad595b401b65fa1c83b
  # Latitude and longitude range
  area: 116.2,34.5,122,38
````

