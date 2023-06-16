inherit cmake
inherit qmake5_paths

DEPENDS_prepend = "qtbase qtbase-native "

EXTRA_OECMAKE_prepend = " \
    -DOE_QMAKE_PATH_PREFIX=${OE_QMAKE_PATH_PREFIX} \
    -DOE_QMAKE_PATH_HEADERS=${OE_QMAKE_PATH_HEADERS} \
    -DOE_QMAKE_PATH_LIBS=${OE_QMAKE_PATH_LIBS} \
    -DOE_QMAKE_PATH_ARCHDATA=${OE_QMAKE_PATH_ARCHDATA} \
    -DOE_QMAKE_PATH_DATA=${OE_QMAKE_PATH_DATA} \
    -DOE_QMAKE_PATH_BINS=${OE_QMAKE_PATH_BINS} \
    -DOE_QMAKE_PATH_LIBEXECS=${OE_QMAKE_PATH_LIBEXECS} \
    -DOE_QMAKE_PATH_PLUGINS=${OE_QMAKE_PATH_PLUGINS} \
    -DOE_QMAKE_PATH_QML=${OE_QMAKE_PATH_QML} \
    -DOE_QMAKE_PATH_TRANSLATIONS=${OE_QMAKE_PATH_TRANSLATIONS} \
    -DOE_QMAKE_PATH_DOCS=${OE_QMAKE_PATH_DOCS} \
    -DOE_QMAKE_PATH_SETTINGS=${OE_QMAKE_PATH_SETTINGS} \
    -DOE_QMAKE_PATH_EXAMPLES=${OE_QMAKE_PATH_EXAMPLES} \
    -DOE_QMAKE_PATH_TESTS=${OE_QMAKE_PATH_TESTS} \
    -DOE_QMAKE_PATH_HOST_PREFIX=${OE_QMAKE_PATH_HOST_PREFIX} \
    -DOE_QMAKE_PATH_HOST_BINS=${OE_QMAKE_PATH_HOST_BINS} \
    -DOE_QMAKE_PATH_HOST_DATA=${OE_QMAKE_PATH_HOST_DATA} \
    -DOE_QMAKE_PATH_HOST_LIBS=${OE_QMAKE_PATH_HOST_LIBS} \
    -DOE_QMAKE_PATH_EXTERNAL_HOST_BINS=${OE_QMAKE_PATH_EXTERNAL_HOST_BINS} \
    -DOE_QMAKE_PATH_QT_HEADERS=${OE_QMAKE_PATH_QT_HEADERS} \
    -DOE_QMAKE_PATH_QT_ARCHDATA=${OE_QMAKE_PATH_QT_ARCHDATA} \
    -DOE_QMAKE_PATH_QT_DATA=${OE_QMAKE_PATH_QT_DATA} \
    -DOE_QMAKE_PATH_QT_BINS=${OE_QMAKE_PATH_QT_BINS} \
    -DOE_QMAKE_PATH_QT_TRANSLATIONS=${OE_QMAKE_PATH_QT_TRANSLATIONS} \
    -DOE_QMAKE_PATH_QT_DOCS=${OE_QMAKE_PATH_QT_DOCS} \
    -DOE_QMAKE_PATH_QT_SETTINGS=${OE_QMAKE_PATH_QT_SETTINGS} \
    -DOE_QMAKE_PATH_QT_EXAMPLES=${OE_QMAKE_PATH_QT_EXAMPLES} \
    -DOE_QMAKE_PATH_QT_TESTS=${OE_QMAKE_PATH_QT_TESTS} \
"
