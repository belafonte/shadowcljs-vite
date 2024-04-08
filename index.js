import * as i0 from "react-refresh/runtime";
import * as i1 from "react";
import * as i2 from "react-dom/client";
import * as i3 from "react-dom";
import * as i4 from "@@/button";
import * as i5 from "@@/calendar";

const ALL = {};

globalThis.shadow$bridge = function(name) {
  const ret = ALL[name];
  if (ret == undefined) {
    throw new Error("Dependency: " + name + " not provided by external JS!");
  } else {
    return ret;
  }
};

ALL["react-refresh/runtime"] = i0;

ALL["react"] = i1;

ALL["react-dom/client"] = i2;

ALL["react-dom"] = i3;

ALL["@@/button"] = i4;

ALL["@@/calendar"] = i5;
