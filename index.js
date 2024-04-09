import * as i0 from "@@/button";
import * as i1 from "@@/table";
import * as i2 from "react-dom";
import * as i3 from "react-router-dom";
import * as i4 from "@@/card";
import * as i5 from "lucide-react";
import * as i6 from "react-dom/client";
import * as i7 from "@@/input";
import * as i8 from "@tanstack/react-query";
import * as i9 from "react-refresh/runtime";
import * as i10 from "react";

const ALL = {};

globalThis.shadow$bridge = function(name) {
  const ret = ALL[name];
  if (ret == undefined) {
    throw new Error("Dependency: " + name + " not provided by external JS!");
  } else {
    return ret;
  }
};

ALL["@@/button"] = i0;

ALL["@@/table"] = i1;

ALL["react-dom"] = i2;

ALL["react-router-dom"] = i3;

ALL["@@/card"] = i4;

ALL["lucide-react"] = i5;

ALL["react-dom/client"] = i6;

ALL["@@/input"] = i7;

ALL["@tanstack/react-query"] = i8;

ALL["react-refresh/runtime"] = i9;

ALL["react"] = i10;
