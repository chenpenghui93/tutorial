package com.example.javabasic.sample.webservice.axis;

import com.alibaba.fastjson.JSONObject;
import org.apache.axis.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 同步LDAP服务
 *
 * @author chenpenghui
 * @date 2020/7/17
 */
@Service
public class LdapService {

    private final Logger log = LoggerFactory.getLogger(LdapService.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${ldap.tokenUrl}")
    private String tokenUrl;

    @Value("${ldap.eidClass}")
    private String eidClass;

    @Value("${ldap.user.appSecretId}")
    private String userAppSecretId;

    @Value("${ldap.user.appSecretKey}")
    private String userAppSecretKey;

    @Value("${ldap.user.endPoint}")
    private String userEndpoint;

    @Value("${ldap.dept.appSecretId}")
    private String deptAppSecretId;

    @Value("${ldap.dept.appSecretKey}")
    private String deptAppSecretKey;

    @Value("${ldap.dept.endPoint}")
    private String deptEndpoint;

    /**
     * 获取accessToken
     *
     * @param appSecretId
     * @param appSecretKey
     * @return String
     */
    public String getLdapAccessToken(String appSecretId, String appSecretKey) {
        String getTokenUrl = tokenUrl + "?appSecretId=" + appSecretId + "&appSecretKey=" + appSecretKey + "&eidClass=" + eidClass;
        LdapToken LdapToken = restTemplate.getForObject(getTokenUrl, LdapToken.class);
        return LdapToken.getTokenId();
    }

    /**
     * Webservice请求LDAP
     *
     * @param accessToken
     * @param endPoint
     * @param appSecretId
     * @param eid
     * @param params
     * @return String
     */
    public String getLdapResult(String accessToken, String endPoint, String appSecretId, String functionName, String eid, String params) {
        String result = "";
        try {
            org.apache.axis.client.Service service = new org.apache.axis.client.Service();
            Call call = service.createCall();
            call.setTargetEndpointAddress(endPoint);
            call.setOperationName(new QName("http://services.soap.ws.esc.para.com/", functionName));
            Object[] arrayParams = new Object[]{appSecretId, accessToken, eid};
            call.addParameter("appSecretId", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.addParameter("access_token", Constants.XSD_ANYTYPE, ParameterMode.IN);
            call.addParameter("eidClass", Constants.XSD_ANYTYPE, ParameterMode.IN);
            if (StringUtils.isNotEmpty(params)) {
                call.addParameter("params", Constants.XSD_ANYTYPE, ParameterMode.IN);
                arrayParams = new Object[]{appSecretId, accessToken, eid, params};
            }
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            log.info("查询LDAP 开始 ...");
            result = (String) call.invoke(arrayParams);
            log.info("查询LDAP 结束 ...");
        } catch (Exception e) {
            log.error("查询LDAP异常：" + e.getMessage());
        }
        return result;
    }

    /**
     * 获取LDAP用户列表
     *
     * @param userId
     * @return List<LdapUser>
     */
    public List<LdapUser> getLdapUserList(String userId) {
        List<LdapUser> ldapUserList = new ArrayList<>();
        String params = null;
        if (StringUtils.isNotEmpty(userId)) {
            params = "uid=" + userId;
        }
        String accessToken = getLdapAccessToken(userAppSecretId, userAppSecretKey);
        String result = getLdapResult(accessToken, userEndpoint, userAppSecretId, "ldapQueryInfoParams", eidClass, params);
        LdapUserResult ldapUserResult = JSONObject.parseObject(result, LdapUserResult.class);
        if (Objects.nonNull(ldapUserResult) && "SUCCESS".equals(ldapUserResult.getResult().getResCode())) {
            ldapUserList = ldapUserResult.getData();
            log.info("查询LDAP用户成功...");
        }
        return ldapUserList;
    }

    /**
     * 获取LDAP部门列表
     *
     * @param orgName
     * @return List<LdapDept>
     */
    public List<LdapDept> getLdapDeptList(String orgName) {
        List<LdapDept> ldapDeptList = new ArrayList<>();
        String params = null;
        if (StringUtils.isNotEmpty(orgName)) {
            params = "ou=" + orgName;
        }
        String accessToken = getLdapAccessToken(deptAppSecretId, deptAppSecretKey);
        String result = getLdapResult(accessToken, deptEndpoint, deptAppSecretId, "ldapQueryInfo", eidClass, params);
        LdapDeptResult ldapDeptResult = JSONObject.parseObject(result, LdapDeptResult.class);
        if (Objects.nonNull(ldapDeptResult) && "SUCCESS".equals(ldapDeptResult.getResult().getResCode())) {
            ldapDeptList = ldapDeptResult.getData();
            log.info("查询LDAP组织成功...");
        }
        return ldapDeptList;
    }

}
