import * as i0 from "@@/button";
import * as i1 from "@@/table";
import * as i2 from "react-dom";
import * as i3 from "react-router-dom";
import * as i4 from "react-intl";
import * as i5 from "@@/card";
import * as i6 from "@/lang/de.json";
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

ALL["@@/button"] = i0;

ALL["@@/table"] = i1;

ALL["react-dom"] = i2;

ALL["react-router-dom"] = i3;

ALL["react-intl"] = i4;

ALL["@@/card"] = i5;

ALL["@/lang/de.json"] = i6;

ALL["lucide-react"] = i7;

ALL["react-dom/client"] = i8;

ALL["@@/input"] = i9;

ALL["@tanstack/react-query"] = i10;

ALL["react-refresh/runtime"] = i11;

ALL["react"] = i12;
