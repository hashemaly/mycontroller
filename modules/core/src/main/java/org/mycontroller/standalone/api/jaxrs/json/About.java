/*
 * Copyright 2015-2016 Jeeva Kandasamy (jkandasa@gmail.com)
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mycontroller.standalone.api.jaxrs.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.mycontroller.standalone.AppProperties;
import org.mycontroller.standalone.McObjectManager;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jeeva Kandasamy (jkandasa)
 * @since 0.0.2
 */
@Data
@ToString(includeFieldNames = true)
public class About {
    private String timezone;
    private Integer timezoneMilliseconds;
    private String timezoneString;
    private String appVersion;
    private Date systemDate;
    private String appName;
    private String languageId;
    private String language;
    private String dateFormat;
    private String dateFormatWithoutSeconds;
    private String timeFormat;
    private String timeFormatWithoutSeconds;
    private String timeFormatSet;
    private String loginMessage;
    private Long globalPageRefreshTime;
    private Integer dashboardLimit;

    public About() {
        Date date = new Date();
        this.appName = AppProperties.APPLICATION_NAME;
        this.timezoneMilliseconds = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        this.systemDate = date;
        this.timezone = new SimpleDateFormat("Z").format(date);
        this.timezoneString = new SimpleDateFormat("z").format(date);
        this.appVersion = McObjectManager.getAppProperties().getControllerSettings().getVersion();
        this.languageId = McObjectManager.getAppProperties().getLanguage().toString().toLowerCase();
        this.language = McObjectManager.getAppProperties().getLanguage().getText();
        this.loginMessage = McObjectManager.getAppProperties().getControllerSettings().getLoginMessage();
        this.dateFormat = McObjectManager.getAppProperties().getDateFormat();
        this.dateFormatWithoutSeconds = McObjectManager.getAppProperties().getDateFormatWithoutSeconds();
        this.timeFormat = McObjectManager.getAppProperties().getTimeFormat();
        this.timeFormatWithoutSeconds = McObjectManager.getAppProperties().getTimeFormatWithoutSeconds();
        this.timeFormatSet = McObjectManager.getAppProperties().getControllerSettings().getTimeFormat();
        this.globalPageRefreshTime = McObjectManager.getAppProperties().getControllerSettings()
                .getGlobalPageRefreshTime();
        this.dashboardLimit = McObjectManager.getAppProperties().getControllerSettings().getDashboardLimit();
    }
}
