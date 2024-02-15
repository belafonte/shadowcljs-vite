import * as i0 from "react";
import * as i1 from "react-dom/client";

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
