/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.souldj673.comptontoggle.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author souldj673
 */
public class Process {

    private String cmd;
    private String tty;
    private LocalDateTime time;
    private int pid;

    DateTimeFormatter runtime = DateTimeFormatter.ofPattern("hh:mm:ss");

    public Process() {
    }

    public Process(String cmd, String tty, LocalDateTime time, int pid) {
        this.cmd = cmd;
        this.tty = tty;
        this.time = time;
        this.pid = pid;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public DateTimeFormatter getRuntime() {
        return runtime;
    }

    public void setRuntime(DateTimeFormatter runtime) {
        this.runtime = runtime;
    }

}
