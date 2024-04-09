import * as i0 from "react-refresh/runtime";
import * as i1 from "@tanstack/react-query";
import * as i2 from "react";
import * as i3 from "react-dom/client";
import * as i4 from "react-dom";
import * as i5 from "react-router-dom";
import * as i6 from "@@/button";

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

ALL["@tanstack/react-query"] = i1;

ALL["react"] = i2;

ALL["react-dom/client"] = i3;

ALL["react-dom"] = i4;

ALL["react-router-dom"] = i5;

ALL["@@/button"] = i6;
