import * as i0 from "react";
import * as i1 from "react-dom/client";
import * as i2 from "@tanstack/react-query";
import * as i3 from "@radix-ui/react-slot";
import * as i4 from "class-variance-authority";
import * as i5 from "@/components/ui/utils";

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

ALL["@radix-ui/react-slot"] = i3;

ALL["class-variance-authority"] = i4;

ALL["@/components/ui/utils"] = i5;
