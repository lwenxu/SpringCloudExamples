/*
 *
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lwen.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * A loadbalacing strategy that randomly distributes traffic amongst existing
 * servers.
 *
 * @author stonse
 *
 */
public class MyLBRule1 extends AbstractLoadBalancerRule {
    Random rand;
    private int total;
    private int current;

    public MyLBRule1() {
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> servers = lb.getAllServers();
            List<Server> reachableServers = lb.getReachableServers();

            int serverCount = reachableServers.size();
            if (0 == serverCount) {
                return null;
            }

            if (total < 2) {
                server = reachableServers.get(current);
                ++total;
            }else {
                ++current;
                total = 0;
                if (current >= reachableServers.size()) {
                    current = 0;
                }
                server = reachableServers.get(current);
            }

            if (null == server) {
                Thread.yield();
            }
            if (server.isAlive()) {
                return server;
            }

        }
        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
