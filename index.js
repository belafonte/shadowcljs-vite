import * as i0 from "react";
import * as i1 from "react-dom/client";
import * as i2 from "@tanstack/react-query";
import * as i3 from "@@/button";
import * as i4 from "@@/calendar";

const ALL = {};

globalThis.shadow$bridge = function(name) {
  const ret = ALL[name];
  if (ret == undefined) {
    throw new Error("Dependency: " + name + " not provided by external JS!");
  } else {
    return ret;
  }
};

ALL["react"] = i0;

ALL["react-dom/client"] = i1;

ALL["@tanstack/react-query"] = i2;

ALL["@@/button"] = i3;

ALL["@@/calendar"] = i4;
