
module org.peidevs.waro.base {
    requires spring.beans;
    requires spring.context;
    requires spring.core;

    exports org.peidevs.waro.config;
    opens org.peidevs.waro.config.impl;

    exports org.peidevs.waro.player;
    exports org.peidevs.waro.strategy;
    exports org.peidevs.waro.util;
}
