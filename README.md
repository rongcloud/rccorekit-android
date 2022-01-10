# Android Core Kit 文档

- `CoreKit` ：Kit的基础库，主要负责初始化Kit，网络加载Json文件或本地 Json 文件等，优先下载远端配置，远端拉取失败或者未配置 AppKey 的情况下采用本地配置。
- 其他kit需要依赖 `CoreKit` ，并且写一个单例继承 `RCKitInit` ，并命名为 RC${KitName}，该单例为json数据持有者
- 自定义view或弹框需要继承 RCFrameLayout、RCLinearLayout、RCConstraintLayout、RCBottomSheetDialog、RCFragment等
- 自定义组合view的布局文件顶层标签用 <merge> </merge> 来减少层级

# Kit基础组件定义规则

## 基础类型

#### 数值类型 RCNumber

```json
{
  "name": "最大消息数量",
  "type": "RCNumber",
  "value": 50
}
```

#### 字符类型 RCString

```json
{
  "name": "按钮文字",
  "type": "RCString",
  "value": "聊聊吧..."
}
```

#### 布尔类型 RCBoolean

```json
{
  "name": "是否显示",
  "type": "RCBoolean",
  "value": true
}
```

#### 圆角 RCCorner : 左上，右上，左下，右下的圆角

```json
{
  "name": "气泡圆角",
  "type": "RCCorner",
  "value": {
    "topLeft": 0,
    "topRight": 6,
    "bottomLeft": 6,
    "bottomRight": 6
  }
}
```

#### 缩进 RCInsets : 左，上，右，下的 margin 或 padding

```json
{
  "name": "气泡内边距",
  "type": "RCInsets",
  "value": {
    "left": 10,
    "top": 10,
    "right": 10,
    "bottom": 10
  }
}
```

#### 颜色 RCColor : 颜色值 rgb(0~255), a(0~1)

```json
{
  "name": "文字颜色",
  "type": "RCColor",
  "value": {
    "red": 255,
    "green": 255,
    "blue": 255,
    "alpha": 0.8
  }
}
```

#### 图标 RCImage : `local` 本地图片；`remote` 远端图片，优先展示

```json
{
  "name": "按钮背景图片",
  "type": "RCImage",
  "value": {
    "local": "rckit_ic_settings.png",
    "remote": "https://test.png"
  }
}
```

#### 文字 RCFont : 文字大小，`size` 大小，`weight` 字重

```json
{
  "name": "按钮文字大小",
  "type": "RCFont",
  "value": {
    "size": 14,
    "weight": 500
  }
}
```

#### 大小 RCSize : 控件的宽高, `widthMode`和`heightMode` =0：取值宽高， -1：占全宽或全高，-2：包裹内容

```json
{
  "name": "按钮大小",
  "type": "RCSize",
  "value": {
    "width": 100,
    "height": 100,
    "widthMode": 0,
    "heightMode": 0
  }
}
```

## 高级类型

#### 图形 RCDrawable : 代码实现图形

```json
{
  "name": "按钮背景图",
  "type": "RCDrawable",
  "value": {
    "shape": 0,
    // 0矩形，1椭圆形
    "color": {
      // 填充色
      "red": 255,
      "green": 255,
      "blue": 255,
      "alpha": 0.8
    },
    "strokeWidth": 0,
    // 边框宽度
    "strokeColor": {
      // 边框颜色
      "red": 0,
      "green": 0,
      "blue": 0,
      "alpha": 0
    },
    "corner": {
      // 图形圆角
      "topLeft": 0,
      "topRight": 0,
      "bottomLeft": 0,
      "bottomRight": 0
    }
  }
}
```

#### 颜色选择器 RCColorSelector : `normal` 正常颜色，`selected` 选中的颜色

```json
{
  "name": "按钮颜色选择器",
  "type": "RCColorSelector",
  "value": {
    "normal": {
      "red": 255,
      "green": 255,
      "blue": 255,
      "alpha": 0.8
    },
    "selected": {
      "red": 255,
      "green": 255,
      "blue": 255,
      "alpha": 0.8
    }
  }
}
```

#### 图片选择器 RCImageSelector : `normal` 正常图片，`selected` 选中的图片

```json
{
  "name": "按钮图片选择器",
  "type": "RCImageSelector",
  "value": {
    "normal": {
      "local": "rckit_ic_settings.png",
      "remote": "https://test.png"
    },
    "selected": {
      "local": "rckit_ic_settings_selected.png",
      "remote": "https://test.png"
    }
  }
}
```

#### 文字大小选择器 RCFontSelector : `normal` 正常大小，`selected` 选中大小

```json
{
  "name": "文字大小选择器",
  "type": "RCFontSelector",
  "value": {
    "normal": {
      "size": 14,
      "weight": 500
    },
    "selected": {
      "size": 15,
      "weight": 700
    }
  }
}
```

#### 图形选择器 RCDrawableSelector : `normal` 正常大小，`selected` 选中大小

```json
{
  "name": "文字大小选择器",
  "type": "RCDrawableSelector",
  "value": {
    "normal": {
      "shape": 0,
      // 0矩形，1椭圆形
      "color": {
        // 填充色
        "red": 255,
        "green": 255,
        "blue": 255,
        "alpha": 0.8
      },
      "strokeWidth": 1,
      // 边框宽度
      "strokeColor": {
        // 边框颜色
        "red": 255,
        "green": 255,
        "blue": 255,
        "alpha": 0.8
      },
      "corner": {
        // 图形圆角
        "topLeft": 0,
        "topRight": 6,
        "bottomLeft": 6,
        "bottomRight": 6
      }
    },
    "selected": {
      "shape": 0,
      // 0矩形，1椭圆形
      "color": {
        // 填充色
        "red": 255,
        "green": 255,
        "blue": 255,
        "alpha": 0.8
      },
      "strokeWidth": 1,
      // 边框宽度
      "strokeColor": {
        // 边框颜色
        "red": 255,
        "green": 255,
        "blue": 255,
        "alpha": 0.8
      },
      "corner": {
        // 图形圆角
        "topLeft": 0,
        "topRight": 6,
        "bottomLeft": 6,
        "bottomRight": 6
      }
    }
  }
}
```

#### 单选 RCRadio , `radios`可选项，`selected`选中的选项

```json
{
  "name": "录音质量",
  "type": "RCRadio",
  "value": {
    "radios": [
      {
        "name": "高",
        "type": "RCNumber",
        "value": 1
      },
      {
        "name": "低",
        "type": "RCNumber",
        "value": 0
      }
    ],
    "selected": {
      "name": "低",
      "type": "RCNumber",
      "value": 0
    }
  }
}
```

#### 节点类 RCContainer

```json
{
  "name": "底部工具栏",
  "type": "RCContainer",
  "value": {
    "contentInsets": {
      "name": "消息区域内边距",
      "type": "RCInsets",
      "value": {
        "top": 12,
        "bottom": 0,
        "left": 12,
        "right": 105
      }
    },
    "maxVisibleCount": {
      "name": "最大消息数量",
      "type": "RCNumber",
      "value": 50
    }
  }
}
```

#### 文字，按钮，输入框等相关 RCAttributes （客户端用来对某个特定数据结构做解析用，只会用到其中的某些字段）

```json
{
  "name": "聊天按钮",
  "type": "RCAttributes",
  "value": {
    "textColor": "RCColor",
    "font": "RCFont",
    "text": "测试",
    "hintColor": "RCColor",
    "hintText": "聊一聊吧",
    "background": "RCColor",
    "corner": "RCCorner",
    "drawable": "RCDrawable",
    "imageSelector": "RCImageSelector",
    "colorSelector": "RCColorSelector",
    "fontSelector": "RCFontSelector",
    "backgroundSelector": "RCColorSelector",
    "drawableSelector": "RCDrawableSelector",
    "size": "RCSize",
    "insets": "RCInsets",
    "image": "RCImage"
  }
}
```

## 特殊类型

#### ChatRoomKit 底部工具栏，按钮集合

```json
{
  "name": "底部按钮集合",
  "type": "RCButtonList",
  "value": [
    {
      "icon": {
        "name": "按钮1",
        "type": "RCImage",
        "value": {
          "local": "rckit_ic_toolbar_btn1.png",
          "remote": ""
        }
      },
      "hasBadge": {
        "name": "是否有角标",
        "type": "RCBoolean",
        "value": false
      }
    }
  ]
}
```

## 图片资源命名方式

1. 图片名称为英文小写字母，以 `_` 连结
1. 图片一级名称以 `rckit_` 开头
1. 图片二级名称根据图片类型定义，如：图标 `ic_` ,背景 `bg_` , 图片 `img_` , Tab `_tab` 等
1. 图片三级以后名称以图片具体功能命名

举例：
`rckit_ic_music_add.png`
`rckit_img_empty.png`

