# UsuariosApi

All URIs are relative to *http://localhost:8080/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**actualizarUsuario**](UsuariosApi.md#actualizarUsuario) | **PUT** /v1/usuarios/{id} | Actualizar un usuario |
| [**eliminarUsuario**](UsuariosApi.md#eliminarUsuario) | **DELETE** /v1/usuarios/{id} | Eliminar un usuario |
| [**getUsuarioById**](UsuariosApi.md#getUsuarioById) | **GET** /v1/usuarios/{id} | Obtener un usuario por ID |
| [**getUsuarios**](UsuariosApi.md#getUsuarios) | **GET** /v1/usuarios | Obtener todos los usuarios |
| [**registrarUsuario**](UsuariosApi.md#registrarUsuario) | **POST** /v1/usuarios | Registrar un nuevo usuario |


<a id="actualizarUsuario"></a>
# **actualizarUsuario**
> Usuario actualizarUsuario(id, usuario)

Actualizar un usuario

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UsuariosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    UsuariosApi apiInstance = new UsuariosApi(defaultClient);
    Integer id = 56; // Integer | 
    Usuario usuario = new Usuario(); // Usuario | 
    try {
      Usuario result = apiInstance.actualizarUsuario(id, usuario);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsuariosApi#actualizarUsuario");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |
| **usuario** | [**Usuario**](Usuario.md)|  | |

### Return type

[**Usuario**](Usuario.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Usuario actualizado |  -  |

<a id="eliminarUsuario"></a>
# **eliminarUsuario**
> eliminarUsuario(id)

Eliminar un usuario

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UsuariosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    UsuariosApi apiInstance = new UsuariosApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      apiInstance.eliminarUsuario(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsuariosApi#eliminarUsuario");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Usuario eliminado |  -  |

<a id="getUsuarioById"></a>
# **getUsuarioById**
> Usuario getUsuarioById(id)

Obtener un usuario por ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UsuariosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    UsuariosApi apiInstance = new UsuariosApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      Usuario result = apiInstance.getUsuarioById(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsuariosApi#getUsuarioById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

[**Usuario**](Usuario.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Usuario encontrado |  -  |
| **404** | Usuario no encontrado |  -  |

<a id="getUsuarios"></a>
# **getUsuarios**
> List&lt;Usuario&gt; getUsuarios()

Obtener todos los usuarios

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UsuariosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    UsuariosApi apiInstance = new UsuariosApi(defaultClient);
    try {
      List<Usuario> result = apiInstance.getUsuarios();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsuariosApi#getUsuarios");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Usuario&gt;**](Usuario.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Lista de usuarios |  -  |

<a id="registrarUsuario"></a>
# **registrarUsuario**
> Usuario registrarUsuario(usuario)

Registrar un nuevo usuario

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UsuariosApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/v1");

    UsuariosApi apiInstance = new UsuariosApi(defaultClient);
    Usuario usuario = new Usuario(); // Usuario | 
    try {
      Usuario result = apiInstance.registrarUsuario(usuario);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsuariosApi#registrarUsuario");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **usuario** | [**Usuario**](Usuario.md)|  | |

### Return type

[**Usuario**](Usuario.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Usuario creado |  -  |

