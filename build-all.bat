pushd discovery &                call gradlew clean publishToMavenLocal & popd
pushd gateway &                  call gradlew clean publishToMavenLocal & popd
pushd auth &                     call gradlew clean publishToMavenLocal & popd
pushd persist &                  call gradlew clean build & popd

pushd admin &                    call gradlew clean build & popd
pushd guest &                    call gradlew clean build & popd
pushd restaurant &               call gradlew clean build & popd