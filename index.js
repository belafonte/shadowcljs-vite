import * as i0 from "@/i18n.js";
import * as i1 from "@@/button";
import * as i2 from "react-i18next";
import * as i3 from "@@/table";
import * as i4 from "react-dom";
import * as i5 from "react-router-dom";
import * as i6 from "@@/card";
import * as i7 from "lucide-react";
import * as i8 from "react-dom/client";
import * as i9 from "@@/input";
import * as i10 from "@tanstack/react-query";
import * as i11 from "react-refresh/runtime";
import * as i12 from "react";

const ALL = {};

globalThis.shadow$bridge = function(name) {
  const ret = ALL[name];
  if (ret == undefined) {
    throw new Error("Dependency: " + name + " not provided by external JS!");
  } else {
    return ret;
  }
};

ALL["@/i18n.js"] = i0;

ALL["@@/button"] = i1;

ALL["react-i18next"] = i2;

ALL["@@/table"] = i3;

ALL["react-dom"] = i4;

ALL["react-router-dom"] = i5;

ALL["@@/card"] = i6;

ALL["lucide-react"] = i7;

ALL["react-dom/client"] = i8;

ALL["@@/input"] = i9;

ALL["@tanstack/react-query"] = i10;

ALL["react-refresh/runtime"] = i11;

ALL["react"] = i12;
